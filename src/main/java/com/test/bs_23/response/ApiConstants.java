/**
 * @version 1.0.0
 * @Since May 20, 2021
 * @Author Md. Chabed alam - 601
 * @Project ibcs-bof-erp
 */
package com.test.bs_23.response;

import org.springframework.http.MediaType;

public interface ApiConstants {

    String EXTERNAL_MEDIA_TYPE          = MediaType.APPLICATION_JSON_VALUE;

    // base URL 
    String PRIVATE_ENDPOINT         = "/api/";

    // model URL
    String AUTH_END_POINT               = PRIVATE_ENDPOINT + "auth/";
    String PRODUCT_END_POINT               = PRIVATE_ENDPOINT + "product/";

    String ACTIVE_PATH                  = "active";

    // page able URL and variable
    String PAGEABLE_SIZE                = "size";
    String PAGEABLE_PAGE                = "page";


    String PAGEABLE_PATH                = "pageable/{" + PAGEABLE_PAGE + "}/{" + PAGEABLE_SIZE + "}";


    // find by id
    String PATH_ID                      = "id";




}
