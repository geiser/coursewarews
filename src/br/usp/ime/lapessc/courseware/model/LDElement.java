package br.usp.ime.lapessc.courseware.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.tencompetence.imsldmodel.ILDModel;
import org.tencompetence.imsldmodel.ILDModelObject;
import org.tencompetence.imsldmodel.IMSNamespaces;
import org.tencompetence.imsldmodel.LDModel;
import org.tencompetence.imsldmodel.LDModelFactory;
import org.tencompetence.imsldmodel.activities.IActivityStructureModel;
import org.tencompetence.imsldmodel.activities.ILearningActivityModel;
import org.tencompetence.imsldmodel.activities.ISupportActivityModel;
import org.tencompetence.imsldmodel.activities.impl.ActivityStructureModel;
import org.tencompetence.imsldmodel.activities.impl.LearningActivityModel;
import org.tencompetence.imsldmodel.environments.IConferenceModel;
import org.tencompetence.imsldmodel.environments.IEnvironmentModel;
import org.tencompetence.imsldmodel.environments.ILearningObjectModel;
import org.tencompetence.imsldmodel.environments.IServiceModel;
import org.tencompetence.imsldmodel.environments.impl.ConferenceModel;
import org.tencompetence.imsldmodel.environments.impl.EnvironmentModel;
import org.tencompetence.imsldmodel.environments.impl.LearningObjectModel;
import org.tencompetence.imsldmodel.expressions.IConditionType;
import org.tencompetence.imsldmodel.expressions.IConditionsType;
import org.tencompetence.imsldmodel.expressions.IElseType;
import org.tencompetence.imsldmodel.expressions.IIfType;
import org.tencompetence.imsldmodel.expressions.IIsMemberOfRoleType;
import org.tencompetence.imsldmodel.expressions.IOperatorType;
import org.tencompetence.imsldmodel.expressions.IShowHideType;
import org.tencompetence.imsldmodel.expressions.IThenType;
import org.tencompetence.imsldmodel.expressions.impl.ConditionType;
import org.tencompetence.imsldmodel.expressions.impl.ConditionsType;
import org.tencompetence.imsldmodel.expressions.impl.ElseType;
import org.tencompetence.imsldmodel.expressions.impl.IfType;
import org.tencompetence.imsldmodel.expressions.impl.IsMemberOfRoleType;
import org.tencompetence.imsldmodel.expressions.impl.OperatorType;
import org.tencompetence.imsldmodel.expressions.impl.ShowHideType;
import org.tencompetence.imsldmodel.expressions.impl.ThenType;
import org.tencompetence.imsldmodel.method.IActModel;
import org.tencompetence.imsldmodel.method.IMethodModel;
import org.tencompetence.imsldmodel.method.IPlayModel;
import org.tencompetence.imsldmodel.method.IRolePartModel;
import org.tencompetence.imsldmodel.method.impl.ActModel;
import org.tencompetence.imsldmodel.method.impl.PlayModel;
import org.tencompetence.imsldmodel.method.impl.RolePartModel;
import org.tencompetence.imsldmodel.resources.IResourceModel;
import org.tencompetence.imsldmodel.roles.ILearnerModel;
import org.tencompetence.imsldmodel.roles.IRoleModel;
import org.tencompetence.imsldmodel.roles.impl.LearnerRoleModel;
import org.tencompetence.imsldmodel.types.IItemRefModel;
import org.tencompetence.imsldmodel.types.IItemType;
import org.tencompetence.imsldmodel.types.impl.ItemRefModel;
import org.tencompetence.imsldmodel.types.impl.ItemType;
import org.tencompetence.jdom.JDOMXMLUtils;

import br.usp.ime.lapessc.courseware.util.LDResources;
import br.usp.ime.lapessc.courseware.util.UUID;

public class LDElement implements Serializable, Cloneable {

    private static final long serialVersionUID = 3528703188674716367L;
    public static int count = 0;

    @Override
    public Object clone() {
        LDElement obj = new LDElement();
        obj.setId(this.id);
        obj.setTag(this.tag);
        obj.setParameters(this.parameters);
        obj.setChildren(this.children);
        obj.setIsPartOf(this.isPartOf);
        obj.setType(this.type);
        return obj;
    }

    public enum Type {
        START_LD_ELEMENT ("!startLDElement"),
        END_LD_ELEMENT ("!endLDElement"),
        ADD_USER_TO_ROLE ("!addUserToRole"),
        ADD_USER_TO_GROUP ("!addUserToGroup"),
        INSERT_RESOURCE ("!insertResource"),
        TEXT ("!text");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String toString(){
            return this.value;
        }

        public static Type getByValue(String value) {
            Type returnValue = null;
            for (final Type element : EnumSet.allOf(Type.class)) {
                if (element.toString().equals(value)) {
                    returnValue = element;
                }
            }
            return returnValue;
        }
    }

    private String id = UUID.uuid(10, "ele-");

    private Type type;

    private String tag;

    private List<LDParameter> parameters = new ArrayList<LDParameter>();

    private LDElement isPartOf = null;

    private List<LDElement> children = new ArrayList<LDElement>();

    private Metadata metadata = null;

    public LDElement setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public LDElement setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public void setParameters(List<LDParameter> parameters) {
        List<LDParameter> parametersClone = new ArrayList<LDParameter>(this.getParameters());
        for (LDParameter parameter : parametersClone) {
            removeParameter(parameter);
        }
        for (LDParameter parameter : parameters) {
            addParameter(parameter);
        }
    }

    public List<LDParameter> getParameters() {
        return parameters;
    }

    public LDElement addParameter(LDParameter parameter) {
        parameters.add(parameter);
        parameter.setOperator(this);
        return this;
    }

    public LDElement removeParameter(LDParameter parameter) {
        parameters.remove(parameter);
        parameter.setOperator(null);
        return this;
    }

    public void setIsPartOf(LDElement isPartOf) {
        this.isPartOf = isPartOf;
    }

    public LDElement getIsPartOf() {
        return isPartOf;
    }

    public void setChildren(List<LDElement> children) {
        List<LDElement> childrenClone = new ArrayList<LDElement>(this.getChildren());
        for (LDElement element : childrenClone) {
            removeChild(element);
        }
        for (LDElement element : children) {
            addChild(element);
        }
    }

    public List<LDElement> getChildren() {
        return children;
    }

    public LDElement addChild(LDElement element) {
        this.getChildren().add(element);
        element.setIsPartOf(this);
        return this;
    }

    public LDElement removeChild(LDElement element) {
        this.getChildren().remove(element);
        element.setIsPartOf(null);
        return this;
    }

    public LDElement setMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof LDElement) || (obj == null)) {
            return false;
        }
        LDElement element = (LDElement) obj;
        if (this.id != null) {
            return this.id.equals(element.getId());
        }
        boolean toReturn = (element.getType().equals(this.getType()) && element.getTag().equals(this.getTag()));
        Iterator<LDParameter> parametersOfObj = element.getParameters().iterator();
        while (parametersOfObj.hasNext()) {
            toReturn = toReturn && this.parameters.contains(parametersOfObj.next());
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "{";
        if (this.id != null) toReturn += "id: " + this.id +", ";
        if (this.isPartOf != null && this.isPartOf.getId() != null) toReturn += "isPartOf: " + this.isPartOf.getId() +", ";
        if (this.tag != null) toReturn += "tag: " + this.tag +", ";
        if (this.type != null) toReturn += "type: " + this.type + ", ";
        if (this.parameters != null) toReturn += "parameters: " + this.parameters.toString() + ", ";
        if (this.metadata != null) toReturn += "metadata: " + this.metadata.toString();
        return toReturn + "}";
    }

    public String toXMLString() {
        String result = "";
        if (Type.TEXT.equals(this.type)) {
            String text = this.tag;
            //            if (LDResources.TEXTS.containsKey(this.tag)) {
            //                text = LDResources.TEXTS.get(this.tag);
            //            }
            for (LDParameter parameter : this.parameters) {
                text = text.replaceAll(parameter.getName(), parameter.getValue());
            }
            result += text;
        } else {
            if (this.tag.equals("_or")) { this.tag = "or"; }
            String prefix = "imsld:";
            if ("resources".equals(this.tag) || "resource".equals(this.tag) ||
                    "organizations".equals(this.tag) || "manifest".equals(this.tag)) {
                prefix = "";
            }
            result += "\n<" + prefix + this.tag;
            for (LDParameter param : this.parameters) {
                result += " " + param.getName() + "=\"" + param.getValue() + "\"";
            }
            if (this.children != null && !this.children.isEmpty()) {
                result += ">";
                for (int index = this.children.size() -1; index >= 0; index--) {
                    LDElement subOperator = this.children.get(index);
                    result += subOperator.toXMLString();
                }
                result += (!"title".equals(this.tag) ? "\n" : "") + "</" + prefix + this.tag + ">";
            } else {
                result += " />";
            }
        }
        return result;


    }

    @SuppressWarnings("unchecked")
    public Map<LDElement, File> toUoL(String uolPath) throws Exception {
        Map<LDElement, ILDModel> models = (Map<LDElement, ILDModel>) this.toIMS(new LDModel(), new HashMap<LDElement, ILDModel>());

        Map<LDElement, File> result = new HashMap<LDElement, File>();
        for (LDElement element : models.keySet()) {
            ILDModel model = models.get(element);
            String id = element.getMetadata().getId();
            // -- generate manifest
            File manifestFile = new File(uolPath + File.separator + id);
            if (!manifestFile.exists()) { manifestFile.mkdirs(); }
            manifestFile = new File(uolPath + File.separator + id + File.separator + "imsmanifest.xml");
            model.setManifestFile(manifestFile);
            try {
                saveModel(model);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //-- generate ZIP
            File zipFile = new File(uolPath + File.separator + id + ".zip");
            ZipOutputStream zipOutStream = new ZipOutputStream(new FileOutputStream(zipFile));
            FileInputStream inFile = new FileInputStream(manifestFile);
            zipOutStream.putNextEntry(new ZipEntry("imsmanifest.xml"));
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inFile.read(buffer)) > 0) {
                zipOutStream.write(buffer, 0, length);
            }
            zipOutStream.closeEntry();
            inFile.close();
            zipOutStream.close();
            zipFile = new File(uolPath + File.separator + id + ".zip");

            result.put(element, zipFile);
        }

        return result;
    }


    private static void saveModel(ILDModel ldModel) throws IOException {
        Document doc = new Document();

        /*
         * Root is CP manifest
         */ 
        Element root = new Element("manifest", IMSNamespaces.IMSCP_NAMESPACE_114); //$NON-NLS-1$
        doc.setRootElement(root);

        /*
         * Additional namespaces
         */
        root.addNamespaceDeclaration(IMSNamespaces.IMSLD_NAMESPACE_100_EMBEDDED);
        root.addNamespaceDeclaration(IMSNamespaces.XSI_NAMESPACE);

        /* 
         * Add Schema Location Attribute which is constructed from Target Namespaces
         * and file names of Schemas
         */
        StringBuffer schemaLocationURI = new StringBuffer();

        // CP
        schemaLocationURI.append(root.getNamespace().getURI());
        schemaLocationURI.append(" ");  //$NON-NLS-1$
        schemaLocationURI.append(IMSNamespaces.IMSCP_SCHEMALOCATION_114);
        schemaLocationURI.append(" ");  //$NON-NLS-1$

        // Schema location depends on LD level
        String level = ldModel.getLevel();

        schemaLocationURI.append(IMSNamespaces.IMSLD_NAMESPACE_100.getURI());
        schemaLocationURI.append(" ");  //$NON-NLS-1$
        if("B".equalsIgnoreCase(level)) { //$NON-NLS-1$
            schemaLocationURI.append(IMSNamespaces.IMSLD_SCHEMALOCATION_100B);
        }
        else if("C".equalsIgnoreCase(level)) { //$NON-NLS-1$
            schemaLocationURI.append(IMSNamespaces.IMSLD_SCHEMALOCATION_100C);
        }
        else {
            schemaLocationURI.append(IMSNamespaces.IMSLD_SCHEMALOCATION_100A);
        }

        root.setAttribute(IMSNamespaces.XSI_SCHEMALOCATION, schemaLocationURI.toString(), IMSNamespaces.XSI_NAMESPACE);

        /*
         * Manifest Identifier
         */
        root.setAttribute(LDModelFactory.IDENTIFIER, ldModel.getManifestIdentifier());

        /*
         * Add Learning Design to "organizations" element with LD Namespace
         */
        Element orgs = new Element("organizations", root.getNamespace()); //$NON-NLS-1$
        root.addContent(orgs);

        Element ldRoot = ldModel.toJDOM();
        orgs.addContent(ldRoot);

        /*
         * Resources element
         */
        Element resources = ldModel.getResourcesModel().toJDOM();
        root.addContent(resources);

        // And save the model
        JDOMXMLUtils.write2XMLFile(doc, ldModel.getManifestFile());
    }

    public Object toIMS(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        Object toReturn = null;
        if ("learning-design".equals(this.tag)) {
            toReturn = toLDModel(new LDModel(), result);
        } else if ("method".equals(this.tag)) {
            toReturn = toLDMethodModel(ldModel, result);
        } else if ("play".equals(this.tag)) {
            toReturn = toPlayModel(ldModel, result);
        } else if ("act".equals(this.tag)) {
            toReturn = toActModel(ldModel, result);
        } else if ("role-part".equals(this.tag)) {
            toReturn = toRolePartModel(ldModel, result);
        } else if ("role-ref".equals(this.tag)) {
            toReturn = toRoleModel(ldModel, result);
        } else if ("learner".equals(this.tag)) {
            toReturn = toLearnerModel(ldModel, result);
        } else if ("unit-of-learning-href".equals(this.tag)) {
            toReturn = toModelObjectUoL(ldModel, result);
        } else if ("activity-structure-ref".equals(this.tag) ||
                "learning-activity-ref".equals(this.tag) ||
                "support-activity-ref".equals(this.tag) ||
                "environment-ref".equals(this.tag)) {
            toReturn = toModelObject(ldModel, result);
        } else if ("activity-structure".equals(this.tag)) {
            toReturn = toActivityStructureModel(ldModel, result);
        } else if ("learning-activity".equals(this.tag)) {
            toReturn = toLearningActivityModel(ldModel, result);
        } else if ("activity-description".equals(this.tag)) {
            toReturn = toActivityDescriptionModel(ldModel, result);
        } else if ("item".equals(this.tag)) {
            toReturn =  toItemTypeModel(ldModel, result);
        } else if ("resource".equals(this.tag)) {
            toReturn = toResourceModel(ldModel, result);
        } else if ("environment".equals(this.tag)) {
            toReturn = toEnvironmentModel(ldModel, result);
        } else if ("learning-object".equals(this.tag)) {
            toReturn = toLearningObjectModel(ldModel, result);
        } else if ("service".equals(this.tag)) {
            toReturn = toServiceModel(ldModel, result);
        } else if ("conference".equals(this.tag)) {
            toReturn = toConferenceModel(ldModel, result);
        } else if ("participant".equals(this.tag)) {
            toReturn = toParticipantRoleModel(ldModel, result);
        } else if ("is-member-of-role".equals(this.tag)) {
            toReturn = toIsMemberOfRoleType(ldModel, result);
        } else if ("_or".equals(this.tag)) {
            toReturn = toOrOperatorType(ldModel, result);
        } else if ("if".equals(this.tag)) {
            toReturn = toIfType(ldModel, result);
        } else if("else".equals(this.tag)) {
            toReturn = toElseType(ldModel, result);
        } else if("then".equals(this.tag)) {
            toReturn = toThenType(ldModel, result);
        } else if("show".equals(this.tag)) {
            toReturn = toShowType(ldModel, result);
        } else if("hide".equals(this.tag)) {
            toReturn = toHideType(ldModel, result);
        } else if("item-ref".equals(this.tag)) {
            toReturn = toItemRefModel(ldModel, result);
        } else if ("conditions".equals(this.tag)) { 
            toReturn = toConditionsModel(ldModel, result);
        } else if ("title".equals(this.tag)) {
            toReturn = toTitle();
        }
        return toReturn;
    }

    /* --------------------------------------------------------------------------------- */

    private IIsMemberOfRoleType toIsMemberOfRoleType(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IIsMemberOfRoleType toReturn = new IsMemberOfRoleType(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("ref".equals(parameter.getName())) {
                toReturn.setReferenceIdentifer(parameter.getValue());
            }
        }
        return toReturn;
    }

    private IOperatorType toOrOperatorType(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IOperatorType toReturn = new OperatorType(ldModel, LDModelFactory.OR);
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof IIsMemberOfRoleType) {
                IIsMemberOfRoleType member = (IIsMemberOfRoleType) obj;
                toReturn.addExpressionMemberType(member);
            } else if (obj instanceof ILDModelObject) {
                ILDModelObject member = (ILDModelObject) obj;
                toReturn.addExpressionMemberType(member);
            }
        }
        return toReturn;
    }

    private IIfType toIfType(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IIfType toReturn = new IfType(ldModel);
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof IOperatorType) {
                IOperatorType member = (IOperatorType) obj;
                toReturn.addExpressionMemberType(member);
            } else if (obj instanceof IIsMemberOfRoleType) {
                IIsMemberOfRoleType member = (IIsMemberOfRoleType) obj;
                toReturn.addExpressionMemberType(member);
            } else if (obj instanceof ILDModelObject) {
                ILDModelObject member = (ILDModelObject) obj;
                toReturn.addExpressionMemberType(member);
            }
        }
        return toReturn;
    }

    private IConditionType toElseType(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IElseType toReturn = new ElseType(ldModel);
        IConditionType condition = new ConditionType(toReturn);;
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof IIfType) {
                IIfType child = (IIfType) obj;
                for (ILDModelObject  member: child.getExpressionMemberTypes()) {
                    condition.getIfType().addExpressionMemberType(member);
                }
            } else if (obj instanceof IThenType) {
                IThenType child = (IThenType) obj;
                for (ILDModelObject  member: child.getMembers()) {
                    condition.getThenType().addMember(member);
                }
            }
        }
        return condition;
    }

    private IItemRefModel toItemRefModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IItemRefModel toReturn = new ItemRefModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("ref".equals(parameter.getName())) {
                toReturn.setReferenceIdentifer(parameter.getValue());
            }
        }
        return toReturn;
    }

    private IShowHideType toShowType(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IShowHideType toReturn = new ShowHideType(ldModel, LDModelFactory.SHOW);
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof IItemRefModel) {
                IItemRefModel member = (IItemRefModel) obj;
                toReturn.getMemberReferences().add(member);
            } else if (obj instanceof ILDModelObject) {
                ILDModelObject member = (ILDModelObject) obj;
                toReturn.addMember(member);
            }
        }
        return toReturn;
    }

    private IShowHideType toHideType(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IShowHideType toReturn = new ShowHideType(ldModel, LDModelFactory.HIDE);
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof IItemRefModel) {
                IItemRefModel member = (IItemRefModel) obj;
                toReturn.getMemberReferences().add(member);
            } else if (obj instanceof ILDModelObject) {
                ILDModelObject member = (ILDModelObject) obj;
                toReturn.addMember(member);
            }
        }
        return toReturn;
    }

    private IThenType toThenType(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IThenType toReturn = new ThenType(ldModel);
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof IShowHideType) {
                IShowHideType showHide = (IShowHideType) obj;
                toReturn.addMember(showHide);// .getShowHideTypes().add(showHide);
            } else if (obj instanceof ILDModelObject) {
                ILDModelObject member = (ILDModelObject) obj;
                toReturn.addMember(member);
            }
        }
        return toReturn;
    }

    /* --------------------------------------------------------------------------------- */

    private Object toTitle() {
        LDElement textElement = this.children.get(0);
        String title = LDResources.texts.get(textElement.getTag());
        if (title == null) { title = textElement.getTag(); }
        for (LDParameter param : textElement.getParameters()) {
            title = title.replaceAll(param.getName(), param.getValue());
        }
        title = title.replaceAll("\\{f[0-9]+\\}", "").replaceAll("\\{s[0-9]+\\}", "").trim();
        LDElement.count++;
        title = title.replaceAll("\\{rn\\}", LDElement.count + "");
        return title;
    }

    /* --------------------------------------------------------------------------------- */

    private IConditionsType toConditionsModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IConditionsType toReturn = new ConditionsType(ldModel);
        IConditionType condition = toReturn.addNewCondition();
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            } else if (obj instanceof IIfType) {
                IIfType child = (IIfType) obj;
                for (ILDModelObject  member : child.getExpressionMemberTypes()) {
                    condition.getIfType().addExpressionMemberType(member);
                }
            } else if (obj instanceof IThenType) {
                IThenType child = (IThenType) obj;
                for (ILDModelObject  member : child.getMembers()) {
                    condition.getThenType().addMember(member);
                }
            } else if (obj instanceof IElseType) {
                IElseType child = (IElseType) obj;
                for (ILDModelObject member : child.getMembers()) {
                    condition.getElseType().addMember(member);
                }
            } else if(obj instanceof IConditionType) {
                toReturn.getConditions().add((IConditionType) obj);
            }
        }

        return toReturn;
    }


    /* --------------------------------------------------------------------------------- */

    private IRoleModel toParticipantRoleModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {        
        IRoleModel toReturn = null;
        for (LDParameter param : this.parameters) {
            if ("role-ref".equals(param.getName())) {
                toReturn = (IRoleModel) ldModel.getModelObject(param.getValue());
                break;
            }
        }
        if (toReturn == null) {
            //toReturn = (IRoleModel) ldModel.getRolesModel().getLearners().get(0);
            throw new Exception("role-ref in participant tag must be declared first");
        }
        return toReturn;
    }

    private IConferenceModel toConferenceModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IConferenceModel toReturn = new ConferenceModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("isvisible".equals(parameter.getName())) {
                toReturn.setIsVisible(Boolean.parseBoolean(parameter.getValue()));
            } else if ("conference-type".equals(parameter.getName())) {
                int conftype = 0;
                for (String value : IConferenceModel.TYPE_STRINGS) {
                    if (value.equals(parameter.getValue())) {
                        break;
                    }
                    conftype++;
                }
                toReturn.setType(conftype);
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            } else if (obj instanceof IItemType) {
                IItemType item = (IItemType) obj;
                toReturn.getItem().addChildItem(item);
            } else if (obj instanceof IRoleModel) {
                IRoleModel role = (IRoleModel) obj;
                toReturn.addParticipant(role);
            }
        }
        return toReturn;
    }

    private IServiceModel toServiceModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IServiceModel toReturn = (IServiceModel) this.children.get(0).toIMS(ldModel, result);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("isvisible".equals(parameter.getName())) {
                toReturn.setIsVisible(Boolean.parseBoolean(parameter.getValue()));
            } else if ("class".equals(parameter.getName())) {
                toReturn.setClassString(parameter.getValue());
            }
        }
        return toReturn;
    }

    private ILearningObjectModel toLearningObjectModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        ILearningObjectModel toReturn = new LearningObjectModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("isvisible".equals(parameter.getName())) {
                toReturn.setIsVisible(Boolean.parseBoolean(parameter.getValue()));
            } else if ("class".equals(parameter.getName())) {
                toReturn.setClassType(parameter.getValue());
            } else if ("type".equals(parameter.getName())) {
                if ("none".equals(parameter.getValue())) {
                    toReturn.setType(ILearningObjectModel.TYPE_NONE);
                } else if ("knowledge-object".equals(parameter.getValue())) {
                    toReturn.setType(ILearningObjectModel.TYPE_KNOWLEDGE_OBJECT);
                } else if ("test-object".equals(parameter.getValue())) {
                    toReturn.setType(ILearningObjectModel.TYPE_TEST_OBJECT);
                } else if ("tool-object".equals(parameter.getValue())) {
                    toReturn.setType(ILearningObjectModel.TYPE_TOOL_OBJECT);
                }
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            } else if (obj instanceof IItemType) {
                IItemType item = (IItemType) obj;
                toReturn.getItems().addChildItem(item);
            }
        }
        return toReturn;
    }

    private IEnvironmentModel toEnvironmentModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IEnvironmentModel toReturn = new EnvironmentModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            } else if (obj instanceof ILearningObjectModel) {
                ILearningObjectModel learningObjectModel = (ILearningObjectModel) obj;
                toReturn.addChildAt(learningObjectModel, 0);
                if (element.getMetadata() != null && this.metadata != null) {
                    element.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                    this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(element.getMetadata().getId()));
                }
            } else if (obj instanceof IServiceModel) {
                IServiceModel serviceModel = (IServiceModel) obj;
                toReturn.addChildAt(serviceModel, 0);
                if (element.getMetadata() != null && this.metadata != null) {
                    element.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                    this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(element.getMetadata().getId()));
                }
            } else if (obj instanceof IEnvironmentModel) {
                IEnvironmentModel environmentModel = (IEnvironmentModel) obj;
                toReturn.addChildAt(environmentModel, 0);
                List<LDElement> environments = element.getChildren();
                for (LDElement environment : environments) {
                    if (environment.getMetadata() != null && this.metadata != null) {
                        environment.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(environment.getMetadata().getId()));
                    }
                }
            }
        }
        ldModel.getEnvironmentsModel().addChildAt(toReturn, 0);
        return toReturn;
    }

    private IResourceModel toResourceModel(ILDModel ldModel, Map<LDElement, ILDModel> result) {
        IResourceModel toReturn = new org.tencompetence.imsldmodel.resources.impl.Resource(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("base".equals(parameter.getName())) {
                toReturn.setBase(parameter.getValue());
            } else if ("href".equals(parameter.getName())) {
                toReturn.setHref(parameter.getValue());
            } else if ("type".equals(parameter.getName())) {
                toReturn.setType(parameter.getValue());
            }
        }
        ldModel.getResourcesModel().addResource(toReturn);
        return toReturn;
    }

    private IItemType toItemTypeModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IItemType toReturn = new ItemType(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("isvisible".equals(parameter.getName())) {
                toReturn.setIsVisible(Boolean.parseBoolean(parameter.getValue()));
            } else if ("identifierref".equals(parameter.getName())) {
                toReturn.setIdentifierRef(parameter.getValue());
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            } else if (obj instanceof IItemType) {
                IItemType item = (IItemType) obj;
                toReturn.addChildItem(item);
            }
        }
        return toReturn;
    }

    private List<IItemType> toActivityDescriptionModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        List<IItemType> toReturn = new  ArrayList<IItemType>();
        for (LDElement operator : this.getChildren()) {
            Object obj = operator.toIMS(ldModel, result);
            if (obj instanceof IItemType) {
                toReturn.add((IItemType) obj);
            }
        }
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    private ILearningActivityModel toLearningActivityModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        ILearningActivityModel toReturn = new LearningActivityModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("isvisible".equals(parameter.getName())) {
                toReturn.setIsVisible(Boolean.parseBoolean(parameter.getValue()));
            }
        }

        for (LDElement element : this.getChildren()) {
            if ("learning-objectives".equals(element.tag)) {
                List<LDElement> ldItems = element.getChildren();
                for (LDElement ldItem : ldItems) {
                    IItemType item = ldItem.toItemTypeModel(ldModel, result);
                    toReturn.getLearningObjectivesModel().addChildItem(item);
                }
            } else if ("prerequisites".equals(element.tag)) {
                List<LDElement> ldItems = element.getChildren();
                for (LDElement ldItem : ldItems) {
                    IItemType item = ldItem.toItemTypeModel(ldModel, result);
                    toReturn.getPrerequisitesModel().addChildItem(item);
                }
            } else {
                Object obj = element.toIMS(ldModel, result);
                if (obj instanceof String) {
                    String title = (String) obj;
                    toReturn.setTitle(title);
                } else if (obj instanceof List) {
                    List<IItemType> items = (List<IItemType>) obj;
                    for (IItemType item : items) {
                        toReturn.getDescriptionModel().addChildItem(item);
                    }
                } else if (obj instanceof IItemType) {
                    IItemType item = (IItemType) obj;
                    toReturn.getDescriptionModel().addChildItem(item);
                } else if (obj instanceof IEnvironmentModel) {
                    IEnvironmentModel env = (IEnvironmentModel) obj;
                    toReturn.addEnvironmentRef(env);
                    List<LDElement> environments = element.getChildren();
                    for (LDElement environment : environments) {
                        if (environment.getMetadata() != null && this.metadata != null) {
                            environment.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                            this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(environment.getMetadata().getId()));
                        }
                    }
                }
            }
        }
        ldModel.getActivitiesModel().getLearningActivitiesModel().addChildAt(toReturn, 0);
        return toReturn;
    }

    private IActivityStructureModel toActivityStructureModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IActivityStructureModel toReturn = new ActivityStructureModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("number-to-select".equals(parameter.getName())) {
                toReturn.setNumberToSelect(Double.valueOf(parameter.getValue()).intValue());
            } else if ("structure-type".equals(parameter.getName()) ) {
                if ("sequence".equals(parameter.getValue())) {
                    toReturn.setStructureType(IActivityStructureModel.TYPE_SEQUENCE);
                } else if ("selection".equals(parameter.getValue())) {
                    toReturn.setStructureType(IActivityStructureModel.TYPE_SELECTION);
                }
            } else if ("number-to-select".equals(parameter.getName())) {
                toReturn.setNumberToSelect(Integer.parseInt(parameter.getValue()));
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            } else if (obj instanceof IActivityStructureModel) {
                IActivityStructureModel activityModel = (IActivityStructureModel) obj;
                toReturn.addActivity(activityModel, 0);
                List<LDElement> activityStructures = element.getChildren();
                for (LDElement activityStructure : activityStructures) {
                    if (activityStructure.getMetadata() != null && this.metadata != null) {
                        activityStructure.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(activityStructure.getMetadata().getId()));
                    }
                }
            } else if (obj instanceof ILearningActivityModel) {
                ILearningActivityModel activityModel = (ILearningActivityModel) obj;
                toReturn.addActivity(activityModel, 0);
                List<LDElement> learningActivities = element.getChildren();
                for (LDElement learningActivity : learningActivities) {
                    if (learningActivity.getMetadata() != null && this.metadata != null) {
                        learningActivity.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(learningActivity.getMetadata().getId()));
                    }
                }
            } else if (obj instanceof ISupportActivityModel) {
                ISupportActivityModel activityModel = (ISupportActivityModel) obj;
                toReturn.addActivity(activityModel, 0);
                List<LDElement> suportActivities = element.getChildren();
                for (LDElement suportActivity : suportActivities) {
                    if (suportActivity.getMetadata() != null && this.metadata != null) {
                        suportActivity.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(suportActivity.getMetadata().getId()));
                    }
                }
            } else if (obj instanceof IEnvironmentModel) {
                IEnvironmentModel environmentModel = (IEnvironmentModel) obj;
                toReturn.addEnvironmentRef(environmentModel);
                List<LDElement> environments = element.getChildren();
                for (LDElement environment : environments) {
                    if (environment.getMetadata() != null && this.metadata != null) {
                        environment.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(environment.getMetadata().getId()));
                    }
                }
            }
        }
        ldModel.getActivitiesModel().getActivityStructuresModel().addChildAt(toReturn, 0);
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    private ILearningActivityModel toModelObjectUoL(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        LDElement element = this.getChildren().get(0);
        ILDModel uolModel = ((Map<LDElement, ILDModel>) element.toIMS(ldModel, result)).get(element);
        //-- get resource
        IResourceModel resource = new org.tencompetence.imsldmodel.resources.impl.Resource(ldModel);
        resource.setIdentifier("res-" + UUID.randomUUID().toString());
        resource.setType("webcontent");
        resource.setHref(LDResources.baseURL + "/uol/" + uolModel.getIdentifier() + "/run");
        ldModel.getResourcesModel().addResource(resource);
        //-- get item
        IItemType item = new ItemType(ldModel);
        item.setTitle(uolModel.getTitle());
        item.setIdentifierRef(resource.getIdentifier());
        //-- get learning activity
        ILearningActivityModel toReturn = new LearningActivityModel(ldModel);
        toReturn.setTitle(uolModel.getTitle());
        toReturn.getDescriptionModel().addChildItem(item);
        ldModel.getActivitiesModel().getLearningActivitiesModel().addChildAt(toReturn, 0);
        return toReturn;
    }

    private ILDModelObject toModelObject(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        for (LDElement element : this.getChildren()) {
            element.toIMS(ldModel, result);
        }
        ILDModelObject toReturn = null;
        for (LDParameter parameter : this.getParameters()) {
            if ("ref".equals(parameter.getName())) {
                toReturn = ldModel.getModelObject(parameter.getValue());
                break;
            }
        }
        if (toReturn == null) {
            throw new Exception("reference doesnt exist");
        }
        return toReturn;
    }

    private ILearnerModel toLearnerModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        ILearnerModel toReturn = new LearnerRoleModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("create-new".equals(parameter.getName())) {
                toReturn.setCreateNew(Integer.parseInt(parameter.getValue()));
            } else if ("href".equals(parameter.getName())) {
                toReturn.setHref(parameter.getValue());
            } else if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("match-persons".equals(parameter.getName())) {
                toReturn.setMatchPersons(Integer.parseInt(parameter.getValue()));
            } else if ("max-persons".equals(parameter.getName())) {
                toReturn.setMaxPersons(Integer.parseInt(parameter.getValue()));
            } else if ("min-persons".equals(parameter.getName())) {
                toReturn.setMinPersons(Integer.parseInt(parameter.getValue()));
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            }
        }
        if (ldModel.getModelObject(toReturn.getIdentifier()) == null) {
            ldModel.getRolesModel().addChild(toReturn);
        }
        //ldModel.getRolesModel().getLearners().add(toReturn);
        return toReturn;
    }

    private IRoleModel toRoleModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof ILearnerModel) {                
                ILearnerModel learnerModel = (ILearnerModel) obj;
                String identifier = learnerModel.getIdentifier();
                if (ldModel.getModelObject(identifier) == null) {
                    ldModel.getRolesModel().addChild(learnerModel);
                }
            }
        }
        IRoleModel toReturn = null;
        for (LDParameter parameter : this.getParameters()) {
            if ("ref".equals(parameter.getName())) {
                toReturn = (IRoleModel) ldModel.getModelObject(parameter.getValue());
                break;
            }
        }
        if (toReturn == null) { throw new Exception("role-part must not be null"); }
        return toReturn;
    }

    private IRolePartModel toRolePartModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IRolePartModel toReturn = new RolePartModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);                
            } else if (obj instanceof IRoleModel) {
                IRoleModel roleModel = (IRoleModel) obj;
                toReturn.setRole(roleModel);
                List<LDElement> roles = element.getChildren();
                for (LDElement role : roles) {
                    if (role.getMetadata() != null && this.metadata != null) {
                        role.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(role.getMetadata().getId()));
                    }
                }
            } else if (obj instanceof ILDModelObject) {
                ILDModelObject objModel = (ILDModelObject) obj;
                toReturn.setComponent(objModel);
                List<LDElement> components = element.getChildren();
                for (LDElement component : components) {
                    if (component.getMetadata() != null && this.metadata != null) {
                        component.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(component.getMetadata().getId()));
                    }
                }
            }
        }
        return toReturn;
    }

    private IActModel toActModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IActModel toReturn = new ActModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            }
        }
        //-- iterate over learning-activity
        for (LDElement element : this.getChildren()) {
            if ("activity-structure".equals(element.getTag()) ||  "learning-activity".equals(element.getTag()) || "support-activity".equals(element.getTag())) {
                element.toIMS(ldModel, result);
            }
        }
        //-- iterate over child elements
        for (LDElement element : this.getChildren()) {
            if (!"activity-structure".equals(element.getTag()) && !"learning-activity".equals(element.getTag()) && !"support-activity".equals(element.getTag())) {
                Object obj = element.toIMS(ldModel, result);
                if (obj instanceof String) {
                    String title = (String) obj;
                    toReturn.setTitle(title);
                } else if (obj instanceof IRolePartModel) {
                    IRolePartModel rolePartModel = (IRolePartModel) obj;
                    toReturn.getRolePartsModel().addChildAt(rolePartModel, 0);
                    if (element.getMetadata() != null && this.metadata != null) {
                        element.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                        this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(element.getMetadata().getId()));
                    }
                }
            }
        }
        return toReturn;
    }

    private IPlayModel toPlayModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        IPlayModel toReturn = new PlayModel(ldModel);
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                toReturn.setIdentifier(parameter.getValue());
            } else if ("isvisible".equals(parameter.getName())) {
                toReturn.setIsVisible(Boolean.parseBoolean(parameter.getValue()));
            }
        }
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof String) {
                String title = (String) obj;
                toReturn.setTitle(title);
            } else if (obj instanceof IActModel) {
                IActModel actModel = (IActModel) obj;
                toReturn.getActsModel().addChildAt(actModel, 0);
                if (element.getMetadata() != null && this.metadata != null) {
                    element.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                    this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(element.getMetadata().getId()));
                }
            }
        }
        return toReturn;
    }

    private IMethodModel toLDMethodModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        //-- set role elements
        for (LDElement play : this.getChildren()) {
            if (!"play".equals(play.getTag())) { continue; }
            for (LDElement act : play.getChildren()) {
                if (!"act".equals(act.getTag())) { continue; }
                for (LDElement rolePart : act.getChildren()) {
                    if (!"role-part".equals(rolePart.getTag())) { continue; }
                    for (LDElement roleRef :  rolePart.getChildren()) {
                        if (!"role-ref".equals(roleRef.getTag())) { continue; }
                        for (LDElement role  : roleRef.getChildren()) {
                            role.toIMS(ldModel, result);
                        }
                    }
                }
            }
        }

        //-- set play elements
        for (LDElement element : this.getChildren()) {
            Object obj = element.toIMS(ldModel, result);
            if (obj instanceof IPlayModel) {
                IPlayModel play = (IPlayModel) obj;
                ldModel.getMethodModel().getPlaysModel().addChildAt(play, 0);
            } else if (obj instanceof IConditionsType) {
                IConditionsType condition = (IConditionsType) obj;
                ldModel.getMethodModel().getConditionsModel().addChild(condition);
            }
        }
        return ldModel.getMethodModel();
    }

    private Map<LDElement, ILDModel> toLDModel(ILDModel ldModel, Map<LDElement, ILDModel> result) throws Exception {
        for (LDParameter parameter : this.getParameters()) {
            if ("identifier".equals(parameter.getName())) {
                ldModel.setIdentifier(parameter.getValue());
            } else if ("version".equals(parameter.getName())) {
                ldModel.setVersion(parameter.getValue());
            } else if ("uri".equals(parameter.getName())) {
                ldModel.setURI(parameter.getValue());
            } else if ("level".equals(parameter.getName())) {
                ldModel.setLevel(parameter.getValue());
            } else if ("sequence-used".equals(parameter.getName())) {
                ldModel.setIsSequenceUsed(Boolean.parseBoolean(parameter.getValue()));
            }
        }
        for (LDElement element : this.getChildren()) {
            if ("learning-objectives".equals(element.tag)) {
                List<LDElement> ldItems = element.getChildren();
                for (LDElement ldItem : ldItems) {
                    IItemType item = ldItem.toItemTypeModel(ldModel, result);
                    ldModel.getLearningObjectives().addChildItem(item);
                }
            } else if ("prerequisites".equals(element.tag)) {
                List<LDElement> ldItems = element.getChildren();
                for (LDElement ldItem : ldItems) {
                    IItemType item = ldItem.toItemTypeModel(ldModel, result);
                    ldModel.getPrerequisites().addChildItem(item);
                }
            } else {
                Object obj = element.toIMS(ldModel, result);
                if (obj instanceof String) {
                    String title = (String) obj;
                    ldModel.setTitle(title);
                    this.metadata.addProperty(new Property().setName("hasTitle").setValue(title));
                } else if (obj instanceof IMethodModel) {
                    List<LDElement> plays = element.getChildren();
                    for (LDElement play : plays) {
                        if (play.getMetadata() != null && this.metadata != null) {
                            play.getMetadata().addRelation(new Relation().setName("isPartOf").setDest(this.metadata.getId()));
                            this.metadata.addRelation(new Relation().setName("inverseIsPartOf").setDest(play.getMetadata().getId()));
                        }
                    }
                }
            }
        }
        result.put(this, ldModel);
        return result;
    }
    
    /* --------------------------------------------------------------------------------- */
    
}