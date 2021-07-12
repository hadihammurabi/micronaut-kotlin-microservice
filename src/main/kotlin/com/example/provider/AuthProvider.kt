package com.example.provider

import java.util.ArrayList

import io.micronaut.security.authentication.*
import io.micronaut.http.HttpRequest
import javax.inject.Singleton
import org.reactivestreams.Publisher
import io.reactivex.Maybe
import io.reactivex.Flowable

@Singleton
class AuthProvider : AuthenticationProvider {
    override fun authenticate(
        httpReq: HttpRequest<*>,
        authReq: AuthenticationRequest<*, *>
    ): Publisher<AuthenticationResponse> {
        if (authReq.identity == "tes@mail.com" && authReq.secret == "123123") {
            return Flowable.just(UserDetails(authReq.identity as String, ArrayList()))
        }
        return Flowable.just(AuthenticationFailed("invalid user id or password"))
    }
}
