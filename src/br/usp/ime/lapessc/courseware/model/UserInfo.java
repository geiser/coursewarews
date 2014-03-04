package br.usp.ime.lapessc.courseware.model;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.lapessc.courseware.util.LDResources;

@Component
@ApplicationScoped
public class UserInfo {

    private String mediatorURL;

    public String getMediatorURL() {
        if (this.mediatorURL == null) {
            return LDResources.DEFAULT_MEDIATOR_URL;
        }
        return mediatorURL;
    }

    public void setMediatorURL(String URL) {
        this.mediatorURL = URL;
    }
    
}
