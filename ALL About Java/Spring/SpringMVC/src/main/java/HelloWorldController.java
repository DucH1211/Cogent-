import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	@RequestMapping(path ="greet/{name}",method = RequestMethod.GET)
	public String sayHello(@PathVariable String name,ModelMap model) {
		String message = "Hello " + name + "How are you";
		model.addAttribute("greeting",message);
		return "greet";
	}
	

}
