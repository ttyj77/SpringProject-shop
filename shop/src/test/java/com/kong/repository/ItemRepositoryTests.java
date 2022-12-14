package com.kong.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.kong.constant.ItemSellStatus;
import com.kong.entity.Item;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class ItemRepositoryTests {

	@Autowired
	ItemRepository itemRepository;

	@Test
	@DisplayName("상품 저장 테스트")
	public void createItemTest() {
		Item item = new Item();
		item.setItemNm("테스트 상품");
		item.setPrice(10000);
		item.setItemDetail("테스트 상품 상세 설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		Item saveItem = itemRepository.save(item);
		System.out.println(saveItem.toString());
		}
		
		public void createItemList() {
			for(int i=1;i<=10;i++) {
				Item item = new Item();
				item.setItemNm("테스트 상품" + i);
				item.setPrice(10000 + i);
				item.setItemDetail("테스트 상품 상세 설명" + i);
				item.setItemSellStatus(ItemSellStatus.SELL);
				item.setStockNumber(100);
				item.setRegTime(LocalDateTime.now());
				item.setUpdateTime(LocalDateTime.now());
				Item saveItem = itemRepository.save(item);
			}
		}
		
		@Test
		@DisplayName("상품 조회 테스트")
		public void findByItemNmTest() {
			this.createItemList();
			List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
			for(Item item : itemList){
				System.out.println(item.toString());
			}
			
		}
	
	
	
	
	
	//	@Test
//	void contextLoads() {
//		
//		
//	}

}
