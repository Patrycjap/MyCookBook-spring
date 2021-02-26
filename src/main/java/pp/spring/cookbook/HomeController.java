package pp.spring.cookbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pp.spring.cookbook.Recipe.RecipeService;

@Controller
public class HomeController {

    RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("bestRecipes", recipeService.findTop2ByOrderByCountLikeDesc());
        return "home";
    }
}