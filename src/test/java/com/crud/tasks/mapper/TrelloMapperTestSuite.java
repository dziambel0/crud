package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoard(){
        // Given
        List<TrelloBoardDto> boardDtos = Arrays.asList(
                new TrelloBoardDto("boardId1", "Board 1", Arrays.asList(
                        new TrelloListDto("listId1", "List 1", false),
                        new TrelloListDto("listId2", "List 2", true)
                )),
                new TrelloBoardDto("boardId2", "Board 2", Arrays.asList(
                        new TrelloListDto("listId3", "List 3", false),
                        new TrelloListDto("listId4", "List 4", true)
                ))
        );

        // When
        List<TrelloBoard> boards = trelloMapper.mapToBoards(boardDtos);

        // Then
        assertEquals(2, boards.size());
        assertEquals("boardId1", boards.get(0).getId());
        assertEquals("Board 1", boards.get(0).getName());
    }
    @Test
    public void testMapToBoardDto(){
        // Given
        List<TrelloBoard> boards = Arrays.asList(
                new TrelloBoard("boardId1", "Board 1", Arrays.asList(
                        new TrelloList("listId1", "List 1", false),
                        new TrelloList("listId2", "List 2", true)
                )),
                new TrelloBoard("boardId2", "Board 2", Arrays.asList(
                        new TrelloList("listId3", "List 3", false),
                        new TrelloList("listId4", "List 4", true)
                ))
        );

        // When
        List<TrelloBoardDto> boardsDto = trelloMapper.mapToBoardsDto(boards);

        // Then
        assertEquals(2, boardsDto.size());
        assertEquals("boardId1", boardsDto.get(0).getId());
        assertEquals("Board 1", boardsDto.get(0).getName());
    }
    @Test
    public void testMapToListDto(){
        //Given
        List<TrelloList> lists = Arrays.asList(
                new TrelloList("listId1", "List 1", false),
                new TrelloList("listId2", "List 2", true)
        );

        //When
        List<TrelloListDto> listDtos = trelloMapper.mapToListDto(lists);

        //Then
        assertEquals(2, listDtos.size());
        assertEquals("listId1", listDtos.get(0).getId());
        assertEquals("List 1", listDtos.get(0).getName());
    }
    @Test
    public void testMapToList(){
        //Given
        List<TrelloListDto> listsDto = Arrays.asList(
                new TrelloListDto("listId1", "List 1", false),
                new TrelloListDto("listId2", "List 2", true)
        );

        //When
        List<TrelloList> list = trelloMapper.mapToList(listsDto);

        //Then
        assertEquals(2, list.size());
        assertEquals("listId1", list.get(0).getId());
        assertEquals("List 1", list.get(0).getName());
    }
    @Test
    public void testMapToCardDto(){
        //Given
        TrelloCard card = new TrelloCard("Card name", "Card dercription", "top", "cardId1");

        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);

        //Then
        assertEquals("Card name", cardDto.getName());
        assertEquals("Card dercription", cardDto.getDescription());
        assertEquals("top", cardDto.getPos());
        assertEquals("cardId1", cardDto.getListId());
    }
    @Test
    public void testMapToCard(){
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("Card name", "Card dercription", "top", "cardId1");

        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        //Then
        assertEquals("Card name", card.getName());
        assertEquals("Card dercription", card.getDescription());
        assertEquals("top", card.getPos());
        assertEquals("cardId1", card.getListId());
    }
}
