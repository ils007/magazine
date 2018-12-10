package service;

import domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
    @Transactional
    public Category get(Long id) {
        return categoryRepository.getOne(id);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
}
