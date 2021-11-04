package ru.storage.project.service;

import ru.storage.project.model.Author;
import ru.storage.project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ru.library.Util;

import javax.persistence.EntityManager;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    public AuthorRepository authorRepository;

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
        Util.addSmile("ooo");
        return null;
    }



}
