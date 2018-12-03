package net.mse.pxrback.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.mse.pxrback.dao.CategoryDAO;
import net.mse.pxrback.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Commenting the Static part private static List<Category> categories = new
	 * ArrayList<>();
	 * 
	 * 
	 * static { Category category = new Category(); //adding first category
	 * category.setId(1); category.setName("Television");
	 * category.setDescription("This is some description for television");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * categories.add(category);
	 * 
	 * //adding second category category = new Category(); category.setId(2);
	 * category.setName("Mobile");
	 * category.setDescription("This is some description for mobile");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * categories.add(category);
	 * 
	 * //adding third category category = new Category(); category.setId(3);
	 * category.setName("Laptop");
	 * category.setDescription("This is some description for laptop");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * categories.add(category);
	 * 
	 * //adding 4th category category = new Category(); category.setId(4);
	 * category.setName("Tablet");
	 * category.setDescription("This is some description for laptop");
	 * category.setImageURL("CAT_4.png");
	 * 
	 * categories.add(category);
	 * 
	 * } Done Commenting the static part
	 */

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	/*
	 * Get Single Category based on id
	 * 
	 */

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			// add category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Update a single category
	 * 
	 */
	@Override
	public boolean update(Category category) {

		try {
			// update category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Delete a single category
	 * 
	 */
	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		
		try {
			// update category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
