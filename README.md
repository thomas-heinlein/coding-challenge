# Coding Challenge

Implementation of a coding challenge with the following limitations:

- Buy 1 get 1 free sales deal not implemented.
- Inventory can be more efficient: It currently uses a List to store products but a Hash Map would be more efficient
- Sales Deal logic does not work for multiple sales deals. Example: If you combine "10% Off" with "Buy 1 get 1 free", then both deals can be applied for the same product, i.e. you get 10% off AND the product for free. 