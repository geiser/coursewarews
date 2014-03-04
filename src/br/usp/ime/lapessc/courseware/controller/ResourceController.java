package br.usp.ime.lapessc.courseware.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.usp.ime.lapessc.courseware.model.Metadata;
import br.usp.ime.lapessc.courseware.model.Resource;
import br.usp.ime.lapessc.courseware.util.MySQLDAO;

public class ResourceController {
	
	private Result result;

	public ResourceController(Result result) {
			this.result = result;
	}
	
	@Get
	@Path("/resources/{id}")
	public void show(String id) {
		boolean editor = true;
		Resource resource = MySQLDAO.getResource(id);
		String sql = "SELECT * FROM resources WHERE id='" + id + "'";
		MySQLDAO mysql = new MySQLDAO();
		List<Map<String, Object>> resultado = mysql.executeQuery(sql, Arrays.asList(new String[]{"body"}), Arrays.asList(new String[]{"String"}));
		mysql.close();
		if (!resultado.isEmpty()) {
			Map<String, Object> element = resultado.get(0);
			resource.setBody((String) element.get("body"));
		}
		//--
		Metadata metadata = MySQLDAO.getMetadataFromResource(id);
		if (metadata.getTypes().contains("Service")) {
			String type = metadata.getProperties("hasType").iterator().next().getValue();
			if ("synchronous".equals(type)) {
				resource.setBody("");
			} else {
				resource.setBody("");
			}
			editor = false;
		}
		this.result.include("editor", editor);
		this.result.include("resource", resource);
	}

	@Post
	@Path("/resources")
	public void create(Resource resource) {
		boolean editor = true;
		Metadata metadata = MySQLDAO.getMetadataFromResource(resource.getId());
		if (metadata.getTypes().contains("Service")) {
			String type = metadata.getProperties("hasType").iterator().next().getValue();
			if ("synchronous".equals(type)) {
				resource.setBody("");
			} else {
				resource.setBody("");
			}
			editor = false;
		}
		//--
		String sql = "INSERT INTO resources(id, title, body) VALUES ('" +
				resource.getId() + "', '" +
				resource.getTitle() + "', '" +
				resource.getBody() +
				"') ON DUPLICATE KEY UPDATE body = '" +
				resource.getBody() + "'";
		MySQLDAO mysqlDAO = new MySQLDAO();
		if (mysqlDAO.execute(Arrays.asList(new String[]{sql}))){
			mysqlDAO.close();
		}
		this.result.include("editor", editor);
		this.result.include("resource", resource);
	}
	
}