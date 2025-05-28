# 📦 Tracking Number Service

### 🧪 API Endpoint

Swagger Url : https://web-production-92542.up.railway.app/webjars/swagger-ui/index.html#/tracking-number-controller/getTrackingNumber

Sample Curl :
curl -X 'GET' \
  'http://web-production-92542.up.railway.app/api/v1/next-tracking-number?originCountryId=LU&destinationCountryId=AL&weight=1&createdAt=2025-05-28T18%3A20%3A23.857Z&customerId=3fa85f64-5717-4562-b3fc-2c963f66afa6&customerName=ahmad&customerSlug=damn' \
  -H 'accept: */*'

### ✅ Response Format

```json
{
  "tracking_number": "ABC123XYZ",
  "created_at": "2023-01-01T12:00:00Z"
}
```
