package ru.job4j.tracker.lombok;

import lombok.*;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @EqualsAndHashCode.Include
    @NonNull
    private int id;

    @Setter
    private String name;
}
