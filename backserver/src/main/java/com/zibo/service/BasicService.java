package com.zibo.service;

import com.google.common.collect.Lists;
import com.zibo.entity.IEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BasicService<T extends IEntity, ID> {
    protected PagingAndSortingRepository<T, ID> pagingAndSortingRepository;

    public BasicService() {
    }

    public BasicService(PagingAndSortingRepository pagingAndSortingRepository) {
        this.pagingAndSortingRepository = pagingAndSortingRepository;
    }

    public List<T> getList(Sort.Order... order) {
        Sort.Order idOrder = new Sort.Order(Sort.Direction.ASC, "id");
        Sort sort;
        if (order.length == 0) {
            sort = Sort.by(idOrder);
        } else {
            sort = Sort.by(order);
        }
        List<T> result = Lists.newArrayList(pagingAndSortingRepository.findAll(sort));
        return result.stream().filter(t -> !t.isDeleted()).collect(Collectors.toList());
    }

    public T getById(ID id) {
        return pagingAndSortingRepository.findById(id).orElse(null);
    }

    public T saveOrUpdate(T t) {
        return pagingAndSortingRepository.save(t);
    }

    public void saveOrUpdateAll(List<T> list) {
        pagingAndSortingRepository.saveAll(list);
    }

    public T deleteEntity(ID id) {
        T t = getById(id);
        t.setDeleted(true);
        return pagingAndSortingRepository.save(t);
    }

    public T delete(T t) {
        t.setDeleted(true);
        return pagingAndSortingRepository.save(t);
    }
}
