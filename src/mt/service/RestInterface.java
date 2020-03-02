/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.service;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author John
 */
public interface RestInterface {
        
    // login
    @FormUrlEncoded
    @POST("api/login")
    Call<ResponseBody> postLogin(@Field("email") String email, @Field("password") String password);
    
    // login
    @Multipart    
    @POST("api/tournaments/gameEvidenceUpload")
    Call<ResponseBody> postUploadImage(@Part MultipartBody.Part filePart, @Header("Authorization") String authHeader);
    
}
