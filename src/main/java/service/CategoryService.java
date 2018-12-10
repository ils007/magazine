package service;

import domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAll();
    public Category get(Long id);
    public void save(Category category);
}
