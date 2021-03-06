package org.ovirt.mobile.movirt.rest.client.requestfactory.verifier;

import org.androidannotations.annotations.EBean;

import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

@EBean
public class ListHostnameVerifier implements HostnameVerifier {
    private static final String TAG = ListHostnameVerifier.class.getSimpleName();

    private List<String> trustedHosts;

    public boolean verify(String hostname, SSLSession session) {
        if (trustedHosts == null) {
            return false;
        }

        return trustedHosts.contains(hostname);
    }

    public void setTrustedHosts(String[] trustedHosts) {
        this.trustedHosts = Arrays.asList(trustedHosts);
    }
}
