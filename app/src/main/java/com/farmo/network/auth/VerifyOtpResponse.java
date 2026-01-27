package com.farmo.network.auth;

import com.google.gson.annotations.SerializedName;

public class VerifyOtpResponse {
    @SerializedName("verified")
    private boolean verified;

    @SerializedName("error")
    private String error;

    public boolean isVerified() { return verified; }
    public String getError() { return error; }
}
