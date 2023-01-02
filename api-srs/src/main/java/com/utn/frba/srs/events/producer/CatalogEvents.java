package com.utn.frba.srs.events.producer;

public class CatalogEvents {

    public static final String ROUND_FINISH_EVENT = "com.utn.frba.srs.RoundFinishEvent";
    public static final String ROUND_MARK_CHECKPOINT_EVENT = "com.utn.frba.srs.RoundMarkCheckpointEvent";
    public static final String ROUND_NOTIFY_UBICATION_AGENT_EVENT = "com.utn.frba.srs.RoundNotifyUbicationAgentEvent";
    public static final String ROUND_START_EVENT = "com.utn.frba.srs.RoundStartEvent";
    public static final String PLANNING_ROUND_EVENT = "com.utn.frba.srs.PlanningRoundEvent";

    private CatalogEvents() {
    }
}
