package ru.storage.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import ru.storage.project.dto.SearchDTO;
import ru.storage.project.model.Author;
import ru.storage.project.model.Book;
import ru.storage.project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ru.storage.project.repository.BookRepository;

import javax.persistence.EntityManager;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceBook {

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    EntityManager entityManager;

    public Author getAuthor(int id) {
       /* EntityGraph entityGraph = entityManager.getEntityGraph("author-entity-graph-with-book-and-sheet");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.where(criteriaBuilder.equal(root.<Long>get("id"), id));
        TypedQuery<Author> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("javax.persistence.loadgraph", entityGraph);
        return typedQuery.getSingleResult();*/
//        Util.addSmile("ooo");
        return null;
    }


    public List<Book> search(SearchDTO searchDTO) {
        Specification<Book> bookSpecification = SpecificationUtil.findByFieldName(searchDTO.getNameBook(),"nameBook");
        return bookRepository.findAll(bookSpecification);
    }

    public List<Book> searchAndSort(SearchDTO searchDTO, boolean asc) {
        Specification<Book> bookSpecification = SpecificationUtil.findByFieldName(searchDTO.getNameBook(),"nameBook");
        Sort sort = SortingUtil.getSortByBookId();

        sort = SortingUtil.sortDescending(asc, sort);

        return bookRepository.findAll(bookSpecification, sort);
    }


    public Page<Book> searchAndSort(SearchDTO searchDTO) {

        Specification<Book> byFieldName = SpecificationUtil.findByFieldName(searchDTO.getNameBook(), "nameBook");

        Specification<Book> byAuthorNameAndNameBook = SpecificationUtil.addSearchByAuthorName(searchDTO.getAuthorName(), byFieldName);

        Sort sort = SortingUtil.getSortByAuthorName();

        sort = SortingUtil.sortDescending(searchDTO.isAsc(), sort);

        PageRequest pageRequest = PageRequest.of(0, 10, sort);

        bookRepository.findAll(byAuthorNameAndNameBook, pageRequest);

        return bookRepository.findAll(byAuthorNameAndNameBook, pageRequest);
    }


}
