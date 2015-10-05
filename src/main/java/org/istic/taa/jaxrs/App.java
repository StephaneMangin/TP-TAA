package org.istic.taa.jaxrs;

import org.istic.taa.jaxrs.resources.*;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by stephane on 05/10/15.
 */
public class App extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(UserResources.class);
        clazzes.add(TeamResources.class);

        return clazzes;
    }

}
