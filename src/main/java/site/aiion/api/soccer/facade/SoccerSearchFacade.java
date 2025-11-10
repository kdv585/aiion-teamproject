package site.aiion.api.soccer.facade;

import site.aiion.api.common.domain.Messenger;

public interface SoccerSearchFacade {
    Messenger searchByKeyword(String keyword, String entityType);
}

