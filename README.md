# map-server
with spring webflux & reactive mongodb

Desc:
Chart URL : http://map-server-aluckyanto.herokuapp.com <br>
POST URL  : http://map-server-aluckyanto.herokuapp.com/api/invoice/save
<pre>
    {
        "number": "INV-20190402-2201-0001",
        "date": 20190403,
        "storeCode": "2202",
        "storeName": "Starbuck margo",
        "totalPrice": 30000,
        "createdDate": "2019-04-03T16:03:03.031+0000",
        "invoiceDetails": [
            {
                "itemCode": "CAP001",
                "itemName": "Cappucino",
                "price": 50000,
                "quantity": 3,
                "totalPrice": 150000
            },
            {
                "itemCode": "CAP002",
                "itemName": "Cappucino",
                "price": 50000,
                "quantity": 1,
                "totalPrice": 50000
            },
            {
                "itemCode": "CAP003",
                "itemName": "Cappucino",
                "price": 50000,
                "quantity": 2,
                "totalPrice": 100000
            }
        ]
    }
</pre>