package gateways

import models._
import services.{AccountService, InventoryService, PurchaseService}

/**
  * Created by jaimes on 4/12/16.
  */
object WebGateway {

  def cartCheckout(cart: Cart, paymentInfo: PaymentInfo, shippingInfo: ShippingInfo) =
    PurchaseService.processCart(cart,paymentInfo,shippingInfo)

  def getAvailableInventory() =
    InventoryService.getInventory()

  def registerAccount(account: Account) =
    AccountService.register(account)

  def addProduct(p: Product) = ???

  def viewOrderHistory(): OrderHistory = ???

}
