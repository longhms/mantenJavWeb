package com.javweb.mantenjavweb.repository;
/**
 * Copyright(C) [2026] [Luvina Software Company]
 * <p>
 * [UserRepository.java], [Apr 6 ,2026] [ntlong]
 */

import com.javweb.mantenjavweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Tao repository extends JpaRepository de lien lac voi database
 * author : [ntlong]
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
