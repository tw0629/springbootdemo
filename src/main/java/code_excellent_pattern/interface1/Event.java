package code_excellent_pattern.interface1;

import lombok.Getter;

import java.util.UUID;

/**
 * @author David Tian
 * @desc
 * @since 2020-12-13 18:29
 */
@Getter
public abstract class Event<T> {
    private UUID id = UUID.randomUUID();
    private int version = 1;

    protected abstract void applyOn(T aggregate);
}