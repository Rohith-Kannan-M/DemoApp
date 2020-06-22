<?php
 
  // if($_SERVER['REQUEST_METHOD']=='POST'){
  // echo $_SERVER["DOCUMENT_ROOT"];  // /home1/demonuts/public_html
//including the database connection file
    include_once("config.php");
    $userid = $_POST['userid'];
		
	
	 	$query = mysqli_query($con, "SELECT * FROM courses");
			
	        if(mysqli_num_rows($query) > 0){  
	         
					$response = array();
					while($row=mysqli_fetch_assoc($query)){
						array_push($response,
						array(
						'courseid' =>$row['courseid'],
						'coursename' =>$row['coursename'],
						'duration' =>$row['duration'],
						'tutor' =>$row['tutor'],
						'price' =>$row['price'],
						'coursepic' =>$row['coursepic'])
						);
					}
	           echo json_encode($response);
	        }else{ 
	        	echo json_encode("No data");
	        }
	         mysqli_close($con);
	/* }else{
			echo json_encode("Error occured, please try again!") ;
	}*/
?>