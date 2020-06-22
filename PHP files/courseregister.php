<?php
 
   //if($_SERVER['REQUEST_METHOD']=='POST'){
       include_once("config.php");
       
    $userid = $_POST['userid'];
	$courseid = $_POST['courseid'];
 	
	
	//$userid = "mrr";
 	//$courseid = "r19r";
 	
	
 $emparray=array();
if($userid == '' || $courseid == ''){
       echo json_encode(array( "status" => "false","message" => "Parameter missing!") );
}else{

       $query= "SELECT * FROM courseregister WHERE userid='$userid' AND courseid='$courseid'";
       $result= mysqli_query($con, $query);

       if(mysqli_num_rows($result) > 0){
$query= "SELECT * FROM courseregister WHERE userid='$userid' AND courseid='$courseid'";
                   $result= mysqli_query($con, $query);
                   if(mysqli_num_rows($result) > 0){ 
									   
                    while ($row = $result->fetch_assoc()) {
					   $emparray[0]=$row;
            //                        echo $emparray[0]['name'];
                                   }
                    }
          echo json_encode(array( "status" => "false","message" => "Course already registered!","data" => $emparray));
       }else{
		  
$query = "INSERT INTO courseregister (userid,courseid) VALUES ('$userid','$courseid')";
if(mysqli_query($con,$query)){
   
    $query= "SELECT * FROM courseregister WHERE userid='$userid'";
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
 
 ?>
 