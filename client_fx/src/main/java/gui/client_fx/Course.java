package gui.client_fx;

import java.io.Serializable;

/**
 * Classe Serializable qui possede les 3 attributs, tous des strings, nom du cours (name),
 * code du cours (code), session dans laquelle se donne le cours (session)
 */
public class Course implements Serializable {

    private String name;
    private String code;
    private String session;

    public Course(String name, String code, String session) {
        this.name = name;
        this.code = code;
        this.session = session;
    }

    /**
     * Getter pour l'attribut name
     * @return String du valeure de name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter attribut name
     * @param name nouveau name (string)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pour l'attribut code
     * @return String du valeure de code du cours
     */
    public String getCode() {
        return code;
    }
    /**
     * Setter attribut code de cours
     * @param code nouveau code de cours (string)
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter pour l'attribut session
     * @return String du valeure de session
     */
    public String getSession() {
        return session;
    }

    /**
     * Setter attribut session
     * @param session String de la nouvelle valeure de session
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * Override la methode toString() pour effectuer une juxtaposition des 3 attributs de courses tel que:
     * @return un String de la forme "Course{nom_attribut=valeure_attribut,...}"
     */
    @Override
    public String toString() {
        return "Course{" +
                "name=" + name +
                ", code=" + code +
                ", session=" + session +
                '}';
    }
}
