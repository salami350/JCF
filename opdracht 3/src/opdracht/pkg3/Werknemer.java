/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg3;

/**
 *
 * @author Stefan
 */

public class Werknemer {
    
    public String name;
    public String worksFor;
    public Werknemer(String name, String worksFor)
    {
        this.name = name;
        this.worksFor = worksFor;
    }
    public Werknemer(String name)
    {
        this.name = name;
    }
}
