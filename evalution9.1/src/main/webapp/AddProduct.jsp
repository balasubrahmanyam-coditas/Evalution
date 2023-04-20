<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>AddProduct</title>
</head>
<body>


<div class="container">
    <div class="card bg-light">
        <div class="card-body mx-auto"></div>

        <div align="center">
            <h1>Add Product</h1>
        </div>
        <form action="AddProduct" method="get">
            <div class="form-row">


                <div class="col">
                    <label for="input">Name</label>
                    <input type="text" class="form-control" placeholder="Product Name" name="name">
                </div>


                <div class="form-group col-md-6">
                    <label for="input">Price</label>
                    <input type="int" class="form-control" id="input" placeholder="Price" name="price">
                </div>

                 <div class="col">
                       <label for="input">Quantity</label>
                        <input type="text" class="form-control" placeholder="Quantity" name="quantity">
                  </div>

           </div>
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
            </div>
        </div>
    </form>
</div>
</div>

<br>
<a href="ShowProducts.java"><button>Back</button></a>
</body>
