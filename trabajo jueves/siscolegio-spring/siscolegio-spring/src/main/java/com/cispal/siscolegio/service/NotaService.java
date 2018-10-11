/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.service;

import com.cispal.siscolegio.domain.Notas;
import java.util.List;

/**
 *
 * @author JCISNEROSP
 */
public interface NotaService extends ServiceGeneric<Notas> {

    List<Notas> consultarNotaByDniAlumno(Notas notas);

}
