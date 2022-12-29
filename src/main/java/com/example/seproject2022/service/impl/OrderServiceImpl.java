package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.model.dto.CreateOrderRequestDto;
import com.example.seproject2022.model.entity.Product;
import com.example.seproject2022.repository.ProductRepository;
import com.example.seproject2022.service.OrderService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;

    @Override
    public String createOrder(CreateOrderRequestDto createOrderRequestDto,
                              String uri) {
        List<Product> products = new ArrayList<>();
        if (createOrderRequestDto.getProductIds() == null || createOrderRequestDto.getProductIds()
                                                                                  .isEmpty()) {
            throw new CustomException("You must have at least one product in your order", HttpStatus.BAD_REQUEST, uri);
        }
        for (Long productId : createOrderRequestDto.getProductIds()) {
            Product product = productRepository.findProductById(productId)
                                               .orElse(null);
            if (product == null) {
                throw new CustomException(String.format("Product with id=%d doesn't exists", productId), HttpStatus.NOT_FOUND, uri);
            }
            products.add(product);
        }
        createPdf(products);
        return "Successfully created order";
    }

    private void createPdf(List<Product> products) {
        try {
            File ordersFolder = new File("src/main/resources/orders");
            if (!ordersFolder.exists()) {
                if (!ordersFolder.mkdir()) {
                    throw new RuntimeException("Error creating orders folder");
                }
            }
            String hash = UUID.randomUUID()
                              .toString()
                              .substring(0, 7);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/orders/order-" + hash + ".pdf"));
            document.open();
            StringBuilder sb = new StringBuilder();
            sb.append("Your order has been registered!\n\n");
            sb.append("This is a summary of the things you ordered:\n\n");
            for (Product product : products) {
                sb.append(String.format(" - %s", product.getName()))
                  .append("\n");
            }
            document.add(new Paragraph(sb.toString()));
            Calendar calendar = Calendar.getInstance();
            document.add(new Paragraph("\nDate: " + calendar.getTime()));
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException("Error creating pdf");
        }
    }
}
