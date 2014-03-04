= Courseware Web Service =

The *courseware web service* automatically generates personalized UoLs for CSCL based in instructional design strategies extracted from CSCL Script Design Patterns. Our courseware doesn't only define sections and subsections, it defines groups, roles, activities, environments and so on.

| Method | URL                | Description                                                         |
|:------:|:-------------------|:--------------------------------------------------------------------|
| GET    | /uols              | Returns a list of UoLs.                                             |
| POST   | /uols              | Generates a new UoL.                                                |
| GET    | /uols/{id}         | Returns a UoL with identifier {id}.                                 |
| DELETE | /uols/{id}         | Deletes a UoL with identifier {id}.                                 |
| GET    | /uols/{id}/lds     | Returns IMS-LD elements that are part of UoL with identifier {id}.  |
| POST   | /uols/{id}/lds     | Creates an IMS-LD element that are part of UoL with identifier {id}.|
| GET    | /uols/{id}/lds/{e} | Returns an IMS-LD element with identifier {e} that are part of {id}.|
| DELETE | /uols/{id}/lds/{e} | Deletes an IMS-LD element with identifier {e} that are part of {id}.|
| GET    | /initialtask       | Returns a list of restriction used to define an initial task.       |

Table shows the REST API provided by our current version of courseware. The interface */initialtask* returns a list of restrictions that will be used by the interfaces */uols* (method POST), */uols/{id}/lds* (method POST), */uols/{id}/lds/{e}* (method POST) to define the initial task that generates a UoL or an IMS-LD element. The response to a request in this interface is an XML with the form shown in the next Figure, where each element \<task\> contains restrictions of the initial task. The Figure shows a list of restrictions related with the initial task *createLDSession* enables the selection of goal *c17s1k1* (understand derivate at level associative and accretion) that enables the selection of learners *l1* (Josh Hernández) and *l2* (Paul Smith), or goal *c18s3k4* that enables the selection of learner *l3*.

```xml
<tasks>
  <task identifier="createLDSession">
    <goal id="c17s3k1">
      <competency id="c17">Understand Derivate</competency>
      <level id="s3k1">Associative and Accretion</level>
      <learners>
        <learner id="l1">Josh Hernandez</learner>
        <learner id="l2">Paul Smith</learner>
      </learners>
    </goal>
    <goal id="c18s4k3">
      <competency id="c18">Understand Integral</competency>
      <level id="s4k3">Autonomous and Restructuring</level>
      <learners>
        <learner id="l3">Max Martinez</learner>
      </learners>
    </goal>
  </task>
</tasks>
```

