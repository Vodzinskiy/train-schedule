package io04.newsportal.repositories;

import io04.newsportal.models.User;

public interface UserRepository<T> {

    public void store(User t);

    public T retrieve(int id);

    public T search(String name);

    public T delete(int id);

}
