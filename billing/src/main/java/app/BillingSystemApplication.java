package app;

import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import model.*;
import service.DiscountStrategy;
import service.TaxDistrubutor;
import service.TaxStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillingSystemApplication {

    public static void main(String args[]){
      try {
          BillingSystemApplication billingSystemApplication = new BillingSystemApplication();
          List<Item>inventoryDetails=billingSystemApplication.fillInventoryDetails();
          Inventory inventory = new Inventory(inventoryDetails);

          //customer order
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          System.out.println("Enter no of products");
          int n = Integer.parseInt(br.readLine());
          List<ShoppingItem> shoppingLists=new ArrayList<ShoppingItem>();
          for(int i=0;i<n;i++){
              System.out.println("Enter the itemcode");
              String itemCode = br.readLine();
              Item item=inventory.getItemByItemCode(itemCode,inventoryDetails);
              if(item!=null){
                  System.out.println("item"+item.toString());
              }else{
                  System.out.println(" No item found");

              }
              System.out.println("Enter the quantity");
              double quantity = Double.parseDouble((br.readLine()));
              shoppingLists.add(new ShoppingItem(item,quantity));
          }

          List<BillPerItem> billPerItemList=new ArrayList<BillPerItem>();
          for(ShoppingItem eachItem:shoppingLists){
              BillPerItem billPerItem=new BillPerItem(eachItem);
              TaxStrategy taxStrategy= TaxDistrubutor.getCategoyry(eachItem.getItem().getCategory());
              billPerItem.setTotalAmount(billPerItem.generateBill());
              billPerItem.setTax(taxStrategy.calculateTax(billPerItem.getTotalAmount()));
              billPerItem.setTotalAmountAfterTax(billPerItem.getTax()+billPerItem.getTotalAmount());
              System.out.println(eachItem.getItem().getCode() +" "
                              + eachItem.getItem().getCategory()
                              +" "+eachItem.getItem().getUnitPrice()
                              +" " +billPerItem.getTax()
                              +" "+billPerItem.getTotalAmountAfterTax());
              billPerItemList.add(billPerItem);
          }
         //billing starts
          double totalfinalAmount=0.0;
          for(BillPerItem billPerItem:billPerItemList){
              totalfinalAmount+=billPerItem.getTotalAmountAfterTax();
          }
          DiscountStrategy discountStrategy=new DiscountStrategy(totalfinalAmount);
          double discount=discountStrategy.getDiscountAmount();
          System.out.println("discount "+discount);
          System.out.println(" price"+ (totalfinalAmount-discount));

      }
      catch(Exception e){
        System.out.println("msg "+e.getMessage());
        e.printStackTrace();
      }
    }
    private  List<Item> fillInventoryDetails(){
        List<Item> inventoryList= new ArrayList<Item>();
        inventoryList.add(new Item("00001","Cocounut oil", Category.EATABLE,200.0));
        inventoryList.add(new Item("00002","RICE", Category.EATABLE,60.0));
        inventoryList.add(new Item("00004","DAL", Category.EATABLE,120.50));
        inventoryList.add(new Item("00005","Tooth paste", Category.DAILY_USAGE,45.25));
        inventoryList.add(new Item("00006","MakeupKit", Category.COSMETIC,300.0));
        return inventoryList;
    }
}
