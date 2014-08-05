package rollerhockeyfrance.manager.resources;

import rollerhockeyfrance.manager.api.common.Api;

public class RessourceUtils {
    
    public static <T> Api<T> wrap(T data) {
        Api<T> api = new Api<T>();
        api.setData(data);
        return api;
    }
    

}
