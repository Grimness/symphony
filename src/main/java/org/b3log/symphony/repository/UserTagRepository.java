/*
 * Copyright (c) 2012, B3log Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.symphony.repository;

import org.b3log.latke.Keys;
import org.b3log.latke.model.User;
import org.b3log.latke.repository.*;
import org.b3log.symphony.model.Tag;
import org.json.JSONObject;

/**
 * User-Tag relation repository.
 *
 * @author <a href="mailto:DL88250@gmail.com">Liang Ding</a>
 * @version 1.0.0.0, Oct 2, 2012
 * @since 0.2.0
 */
public final class UserTagRepository extends AbstractRepository {

    /**
     * Singleton.
     */
    private static final UserTagRepository SINGLETON = new UserTagRepository(User.USER + "_" + Tag.TAG);

    /**
     * Gets user-tag relations by the specified user id.
     *
     * @param userId the specified user id
     * @param currentPageNum the specified current page number, MUST greater then {@code 0}
     * @param pageSize the specified page size(count of a page contains objects), MUST greater then {@code 0}
     * @return for example
     * <pre>
     * {
     *     "pagination": {
     *       "paginationPageCount": 88250
     *     },
     *     "rslts": [{
     *         "oId": "",
     *         "tag_oId": "",
     *         "user_oId": userId,
     *         "type": "" // "creator"/"article"/"comment", a tag 'creator' is also an 'article' quoter 
     *     }, ....]
     * }
     * </pre>
     * @throws RepositoryException repository exception
     */
    public JSONObject getByUserId(final String userId, final int currentPageNum, final int pageSize) throws RepositoryException {
        final Query query = new Query().setFilter(new PropertyFilter(User.USER + "_" + Keys.OBJECT_ID, FilterOperator.EQUAL, userId)).
                setCurrentPageNum(currentPageNum).setPageSize(pageSize).setPageCount(1);

        return get(query);
    }

    /**
     * Gets user-tag relations by the specified tag id.
     *
     * @param tagId the specified tag id
     * @param currentPageNum the specified current page number, MUST greater then {@code 0}
     * @param pageSize the specified page size(count of a page contains objects), MUST greater then {@code 0}
     * @return for example
     * <pre>
     * {
     *     "pagination": {
     *       "paginationPageCount": 88250
     *     },
     *     "rslts": [{
     *         "oId": "",
     *         "tag_oId": "",
     *         "user_oId": userId,
     *         "type": "" // "creator"/"article"/"comment", a tag 'creator' is also an 'article' quoter 
     *     }, ....]
     * }
     * </pre>
     * @throws RepositoryException repository exception
     */
    public JSONObject getByTagId(final String tagId, final int currentPageNum, final int pageSize) throws RepositoryException {
        final Query query = new Query().setFilter(new PropertyFilter(Tag.TAG + "_" + Keys.OBJECT_ID, FilterOperator.EQUAL, tagId)).
                setCurrentPageNum(currentPageNum).setPageSize(pageSize).setPageCount(1);

        return get(query);
    }

    /**
     * Gets the {@link UserTagRepository} singleton.
     *
     * @return the singleton
     */
    public static UserTagRepository getInstance() {
        return SINGLETON;
    }

    /**
     * Private constructor.
     * 
     * @param name the specified name
     */
    private UserTagRepository(final String name) {
        super(name);
    }
}