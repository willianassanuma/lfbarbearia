package br.edu.tcc.lfbarbearia.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AltenticacaoListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        System.out.println("DEPOIS DA FASE: " + pe.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
