package net.mse.pxrback.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.mse.pxrback.dao.CategoryDAO;
import net.mse.pxrback.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.mse.pxrback");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
				
	}
	
/*	@Test
	public void testAddCategory(){
		
		category = new Category();
		category.setName("Tablet");
		category.setDescription("This is some description for Tablet!");
		category.setImageURL("CAT_4.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
	}*/
	
/*	@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(1);
		
		assertEquals("Successfully fetched a single category from the table!","Television",category.getName());
		
		
	}*/
	
/*	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setImageURL("CAT_3.png");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
	}*/

/*	@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(4);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
	}*/
	
/*	@Test
	public void testListCategory() {
				
		assertEquals("Successfully fetched the list of categories from the table!",3,categoryDAO.list().size());
		
		
	}*/
	
	@Test
	public void testCRUDCategory() {
		
		//add operation
		category = new Category();
		category.setName("Smartwatch");
		category.setDescription("This is some description for Smartwatch!");
		category.setImageURL("CAT_5.png");
		
		assertEquals("Something went wrong while inserting a new category!",true,categoryDAO.add(category));
		
		
		//fetch and update the category
		category = categoryDAO.get(3);
		category.setName("Thinkpad");
		
		assertEquals("Something went wrong while updating a new category!",true,categoryDAO.update(category));
		
		//delete the category
		assertEquals("Something went wrong while deleting a new category!",true,categoryDAO.delete(category));
		
		//list categories
		assertEquals("Something went wrong while fetching the list of categories!",3,categoryDAO.list().size());
	}
	
	
	
	
}
