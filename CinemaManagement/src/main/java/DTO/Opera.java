/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author huyparody
 */
public class Opera {
    private int Opera_Id;
    private String Opera_Name;
    private String tableNote;
    private String tableStatus;
    

    public Opera() {
    }

    public Opera(int Opera_Id, String Opera_Name, String tableNote, String tableStatus) {
        this.Opera_Id = Opera_Id;
        this.Opera_Name = Opera_Name;
        this.tableNote = tableNote;
        this.tableStatus = tableStatus;
    }

    public int getOpera_Id() {
        return Opera_Id;
    }

    public void setOpera_Id(int Opera_Id) {
        this.Opera_Id = Opera_Id;
    }

    public String getOpera_Name() {
        return Opera_Name;
    }

    public void setOpera_Name(String Opera_Name) {
        this.Opera_Name = Opera_Name;
    }

    public String getTableNote() {
        return tableNote;
    }

    public void setTableNote(String tableNote) {
        this.tableNote = tableNote;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    

}
