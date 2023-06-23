import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {
	@RequestMapping("/home")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		// DAO: Data Access Object JPA Repository
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("name", "Duke");
		return mv;
	}

}
