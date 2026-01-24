package com.farmo.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("api/auth/login/")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("api/auth/login-with-token/")
    Call<LoginResponse> loginWithToken(@Body TokenLoginRequest tokenLoginRequest);

    @POST("api/auth/register/")
    Call<MessageResponse> register(@Body RegisterRequest registerRequest);

    @POST("api/auth/forgot-password/")
    Call<ForgotPasswordResponse> forgotPassword(@Body ForgotPasswordRequest forgotPasswordRequest);

    @POST("api/auth/forgot-password-verify-email/")
    Call<MessageResponse> verifyEmail(@Body VerifyEmailRequest verifyEmailRequest);

    @POST("api/auth/forgot-password-verify-otp/")
    Call<MessageResponse> verifyOtp(@Body VerifyOtpRequest verifyOtpRequest);

    @POST("api/auth/forgot-password-change-password/")
    Call<MessageResponse> changePassword(@Body ChangePasswordRequest changePasswordRequest);

    @POST("api/auth/login-change-password/")
    Call<MessageResponse> activateAccount(@Body ActivateAccountRequest activateAccountRequest);

    @POST("api/auth/logout/")
    Call<MessageResponse> logout();

    @GET("api/user/profile/")
    Call<UserProfileResponse> getUserProfile(@Query("user_id") String userId);

    @GET("api/home/dashboard/")
    Call<DashboardResponse> getDashboard(@Query("user_id") String userId);
}
