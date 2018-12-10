package service;

import domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CompanyRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Transactional
    public Company get(Long id) {
        return companyRepository.getOne(id);
    }

    public void save(Company company) {
        companyRepository.save(company);
    }
}
