<?php
 
   //if($_SERVER['REQUEST_METHOD']=='POST'){
       include_once("config.php");
       
   $name = $_POST['name'];
 	$email = $_POST['email'];
 	$password = $_POST['pass'];
	
	//$name = "mrr";
 	//$email = "r1r";
 	//$password = "rmr";
	
 $emparray=array();
if($name == '' || $email == '' || $password == ''){
       echo json_encode(array( "status" => "false","message" => "Parameter missing!") );
}else{

       $query= "SELECT * FROM users WHERE email='$email'";
       $result= mysqli_query($con, $query);

       if(mysqli_num_rows($result) > 0){
$query= "SELECT * FROM users WHERE email='$email' AND pass='$password'";
                   $result= mysqli_query($con, $query);
                   if(mysqli_num_rows($result) > 0){ 
									   
                    while ($row = $result->fetch_assoc()) {
					   $emparray[0]=$row;
            //                        echo $emparray[0]['name'];
                                   }
                    }
          echo json_encode(array( "status" => "false","message" => "Username already exist!","data" => $emparray));
       }else{
		  
$query = "INSERT INTO users (name,email,pass) VALUES ('$name','$email','$password')";
if(mysqli_query($con,$query)){
   
    $query= "SELECT * FROM users WHERE email='$email'";
                    $result= mysqli_query($con, $query);
                    if(mysqli_num_rows($result) > 0){  
					$emparray=array();		
                    while ($row = $result->fetch_assoc()) {
                                     $emparray[0]=$row;
                                   }
                    }
   echo json_encode(array( "status" => "true","message" => "Successfully registered!" ,"data"=>$emparray));
}else{
echo json_encode(array( "status" => "false","message" => "1Error occured, please try again!") );
}
   }
           mysqli_close($con);
}
     /* }else{
echo json_encode(array( "status" => "false","message" => "2Error occured, please try again!") );
}*/
 
 ?>r
 