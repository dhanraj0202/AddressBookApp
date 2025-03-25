import { Component, OnInit } from '@angular/core';
import { AddressBookService } from '../../services/address-book.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  addresses: any[] = [];  

  constructor(private addressBookService: AddressBookService) {}

  ngOnInit(): void {
    this.fetchAddresses();
  }

  fetchAddresses(): void {
    this.addressBookService.getAllAddresses().subscribe({
      next: (response) => {
        console.log("✅ Addresses fetched:", response);
        this.addresses = response;
      },
      error: (err) => {
        console.error('❌ Error fetching addresses:', err);
      }
    });
  }

  deleteAddress(id: number): void {
   
  
    this.addressBookService.deleteAddress(id).subscribe({
      next: () => {
        alert("✅ Address deleted successfully!");
        console.log("✅ Address deleted successfully!");
        this.fetchAddresses(); 
      },
      error: (error) => {
        console.error("❌ Error deleting address:", error);
        alert("❌ Error deleting address. Please try again.");
      }
    });
  }
  
}
