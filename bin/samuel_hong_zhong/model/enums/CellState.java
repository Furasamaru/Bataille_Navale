package school.coda.samuel_hong_zhong.model.enums;

public enum CellState {
    WATER, // Case vide, aucun tir
    MISS,  // Tir dans l'eau (Torpille blanche)
    EMPTY,
    HIT    // Tir sur un bateau (Torpille rouge)
}