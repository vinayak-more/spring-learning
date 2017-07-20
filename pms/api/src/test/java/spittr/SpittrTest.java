package spittr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.spittr.web.bean.Spittle;
import com.spittr.web.controller.HomeController;
import com.spittr.web.controller.SpittleController;
import com.spittr.web.repository.SpittleRepository;

public class SpittrTest {

    
	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(
				MockMvcResultMatchers.view().name("home"));
	}

	@Test
	public void testSpittleController() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository spittleRepository = Mockito
				.mock(SpittleRepository.class);
		Mockito.when(spittleRepository.findSpittles(Long.MAX_VALUE, 20))
				.thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(spittleRepository);
		MockMvc mockMvc = MockMvcBuilders
				.standaloneSetup(controller)
				.setSingleView(
						new InternalResourceView("/WEB-INF/views/spittles.jsp"))
				.build();
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
				.andExpect(MockMvcResultMatchers.view().name("spittles"))
				.andExpect(
						MockMvcResultMatchers.model().attributeExists(
								"spittleList"))
				.andExpect(
						MockMvcResultMatchers.model().attribute("spittleList",
								Matchers.hasItems(expectedSpittles.toArray())));

	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 1; i <= count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}

}
