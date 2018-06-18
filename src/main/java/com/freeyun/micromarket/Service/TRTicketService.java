package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.TRTicket;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.TRTicketRespository;
import com.freeyun.micromarket.Respository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TRTicketService {
    @Autowired
    private TRTicketRespository trTicketRespository;
    @Autowired  private UserRespository userRespository;
    private Logger logger  = LoggerFactory.getLogger(TRTicketService.class);
    public Boolean existByid(String trid)
    {
        TRTicket ticket = null;
        try {
            ticket = trTicketRespository.findById(trid).get();
            return true;
        }catch (Exception e)
        {
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }
    public TRTicket getTicketByid(String trid)
    {
        if (existByid(trid))
        {
            return trTicketRespository.findById(trid).get();
        }
        else {
            return null;
        }
    }
    public int addTRTicket(TRTicket ticket)
    {
        if (existByid(ticket.getTrid()) == false)
        {
            try{
                trTicketRespository.save(ticket);
                return 1;
            }catch (Exception e)
            {
                logger.error(e.getLocalizedMessage());
                return 0;
            }

        }
        else {
            return 0;
        }

    }
    public int deleteTRTicket(String trid)
    {
        if (existByid(trid) == false)
        {
            return -1;
        }
        else {
            try {
                trTicketRespository.deleteById(trid);
                return 1;
            }catch (Exception e)
            {
                logger.error(e.getLocalizedMessage());
                return 0;
            }


        }

    }
    public int updateTRTicket(TRTicket ticket)
    {
        if (existByid(ticket.getTrid()) == false)
        {
            return -1;
        }
        else {
            try {
               trTicketRespository.save(ticket);
                return 1;
            }catch (Exception e)
            {
                logger.error(e.getLocalizedMessage());
                return 0;
            }


        }

    }
    public List<TRTicket> findTRTicketByUser(User user)
    {
        return trTicketRespository.findDistinctByUser(user);
    }
}
