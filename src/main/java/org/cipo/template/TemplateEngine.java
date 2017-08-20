package org.cipo.template;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.parser.ParseException;
import org.jtwig.resource.exceptions.ResourceNotFoundException;
public class TemplateEngine {
	
	
	public void printLogo() {
		JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/logo.txt");

        String result = template.render(JtwigModel.newModel());
        
        System.out.println(result);

		
	}

}
