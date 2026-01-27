package com.farmo.network.auth;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordChangePasswordRequest {
    @SerializedName("user_id")
    private String userId;
    
    @SerializedName("password")
    private String password;

    public ForgotPasswordChangePasswordRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public static class ActivateAccountRequest {
        @SerializedName("identifier")
        private String identifier;
        @SerializedName("old_password")
        private String oldPassword;
        @SerializedName("new_password")
        private String newPassword;

        public ActivateAccountRequest(String identifier, String oldPassword, String newPassword) {
            this.identifier = identifier;
            this.oldPassword = oldPassword;
            this.newPassword = newPassword;
        }
    }
}
