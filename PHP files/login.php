<?php
 
   //if($_SERVER['REQUEST_METHOD']=='POST'){
  // echo $_SERVER["DOCUMENT_ROOT"];  // /home1/demonuts/public_html
//including the database connection file
       include_once("config.php");
       
    $email = $_POST['email'];
 	$password = $_POST['pass'];
	
	//$email = "q";
 	//$password = "q";
 	
	 if( $email == '' || $password == '' ){
	        echo json_encode(array( "status" => "false","message" => "Parameter missing!") );
	 }else{
	 	$query= "SELECT * FROM users WHERE email='$email' AND pass='$password'";
	        $result= mysqli_query($con, $query);
		 
	        if(mysqli_num_rows($result) > 0){  
	         $query= "SELECT * FROM users WHERE email='$email' AND pass='$password'";
	                     $result= mysqli_query($con, $query);
		             $emparray = array();
	                     if(mysqli_num_rows($result) > 0){  
	                 	
                    while ($row = $result->fetch_assoc()) {
                                     $emparray[0]=$row;
                               
                                   }
	                     }
	           echo json_encode(array( "status" => "true","message" => "Login successfully!", "data" => $emparray) );
	        }else{ 
	        	echo json_encode(array( "status" => "false","message" => "Invalid username or password!") );
	        }
	         mysqli_close($con);
	 }
	/*} else{
			echo json_encode(array( "status" => "false","message" => "Error occured, please try again!") );
	}*/
?>