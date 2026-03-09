package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.events.CollectSpecialItemEvent;
import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;
import sofia.sap.interview.project.game.information.RoomInformation;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;
import sofia.sap.interview.project.game.user.User;

import java.util.Set;

public class Gameplay {
    private final Playground playground;
    private Coordinates playerCoordinates;

    public Gameplay(Playground playground) {
        this.playground = playground;
        this.playerCoordinates = Coordinates.startingCoordinates();
    }

    public void movePlayer(Direction direction) {
        if (playground.canMove(this.playerCoordinates, direction)) {
            this.playerCoordinates = direction.move(this.playerCoordinates);
        } else {
            throw new DirectionNotAvailableException(
                    "The provided direction is not correct, choose another direction!");
        }
    }

    public CommandResult lookAround(User user) {
        Enemy enemy = getEnemyOnCharacterCoordinates();
        EnemyType enemyType = enemy != null ? enemy.getType() : null;
        SpecialItem specialItem = getSpecialItemOnPlayerCoordinates();

        if (specialItem != null && user.handleEvent(new CollectSpecialItemEvent(specialItem))) {
            return new EventResult(new CollectSpecialItemEvent(specialItem));
        }
        return new ViewResult(new RoomInformation(getChestOnCharacterCoordinates() != null,
                enemyType, getSpecialItemOnPlayerCoordinates()));
    }

    public Set<Direction> getPossibleDirections() {
        return this.playground.possibleDirections(this.playerCoordinates);
    }

    public Enemy getEnemyOnCharacterCoordinates() {
        return playground.getEnemyByPosition(playerCoordinates);
    }

    public Chest getChestOnCharacterCoordinates() {
        return playground.getChestByPosition(playerCoordinates);
    }

    public SpecialItem getSpecialItemOnPlayerCoordinates() {
        return playground.getSpecialItemByPosition(playerCoordinates);
    }

    public Room getRoom() {
        return this.playground.getRoomByCoordinates(this.playerCoordinates);
    }
}
